package com.example.springbootMybatisdemo2.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyListener implements HttpSessionListener{
	
	public static  int online = 0;
	
	public  void sessionCreated(HttpSessionEvent se) {
		System.out.println("create session");
		online ++;
    }

    /**
     * Notification that a session is about to be invalidated.
     * The default implementation is a NO-OP.
     *
     * @param se
     *            the notification event
     */
    public  void sessionDestroyed(HttpSessionEvent se) {
    }

}
