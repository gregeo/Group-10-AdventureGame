/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.george.instagramwebscraper;

/**
 *
 * @author George Smith
 */
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by vasily on 27.04.17. Login and password which stores in external
 * file. Create a file in PATH which contains login and password
 */
final class Credentials {

    private final static String PATH = "credentials.properties";
    private String login;
    private String password;

    Credentials() throws IOException {
        login = "notabotdontban";
        password = "monkeyman";

    }

    String getLogin() {
        return login;
    }

    String getPassword() {
        return password;
    }

}
