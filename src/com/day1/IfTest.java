package com.day1;

public class IfTest {
    public static void main(String[] args) {
        int heartBeats = 110;
        if (heartBeats > 100 || heartBeats < 60) {
            System.out.println("Need a physical check.");
        } else {
            System.out.println("You are quite well.");
        }
    }
}
