/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import jakarta.servlet.http.HttpSession;
/**
 *
 * @author Admin
 */
public class Flash {
    private static HttpSession session;
    
    public static void init(HttpSession s){
        session = s;
    }
    
    public static void pushMessesage(String message){
        session.setAttribute("message", message);
    }
    
    public static String getMessage(){
        return (String) session.getAttribute("message");
    }
    
    public static void pushError(String error){
        session.setAttribute("error", error);
    }
    
    public static String getError(){
        return (String) session.getAttribute("error");
    }
}
