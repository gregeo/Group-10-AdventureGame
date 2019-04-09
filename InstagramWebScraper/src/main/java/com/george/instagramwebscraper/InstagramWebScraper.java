/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.george.instagramwebscraper;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.postaddict.instagram.scraper.AuthenticatedInsta;
import me.postaddict.instagram.scraper.Instagram;
import me.postaddict.instagram.scraper.cookie.CookieHashSet;
import me.postaddict.instagram.scraper.cookie.DefaultCookieJar;
import me.postaddict.instagram.scraper.interceptor.ErrorInterceptor;
import me.postaddict.instagram.scraper.interceptor.UserAgentInterceptor;
import me.postaddict.instagram.scraper.interceptor.UserAgents;
import me.postaddict.instagram.scraper.model.Account;
import me.postaddict.instagram.scraper.model.Media;
import me.postaddict.instagram.scraper.model.PageObject;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 *
 * @author George Smith
 */
public class InstagramWebScraper {

    private static final String insta = "https://www.instagram.com/explore/tags/vancouver/";
    private static AuthenticatedInsta client;

    public static void main(String[] args) {
        try {
            Credentials credentials = new Credentials();
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
            OkHttpClient httpClient = new OkHttpClient.Builder()
                    .addNetworkInterceptor(loggingInterceptor)
                    .addInterceptor(new UserAgentInterceptor(UserAgents.OSX_CHROME))
                    .addInterceptor(new ErrorInterceptor())
                    .cookieJar(new DefaultCookieJar(new CookieHashSet()))
                    .build();
            client = new Instagram(httpClient);
            client.basePage();
            client.login(credentials.getLogin(), credentials.getPassword());
            client.basePage();

            PageObject<Media> medias = client.getMedias("durov", 1);
            System.out.println(medias.getNodes().get(0).getDisplayUrl());
        } catch (IOException ex) {
            Logger.getLogger(InstagramWebScraper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
