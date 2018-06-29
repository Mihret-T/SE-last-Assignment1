package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

public class Main {

    public static void main(String[] args) {

        Newsfetcher();
        //myWebsite();
    }


    public static void Newsfetcher() {

        ArrayList<String> newsHeadLines = new ArrayList<String>();
        ArrayList<String> newsStories = new ArrayList<String>();

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        //instantiate WebDriver
        WebDriver driver = new ChromeDriver();

        //get specified URL
        driver.get("https://www.bbc.com");

        List<WebElement> headlines = driver.findElements(By.className("media__title"));

        //fetch the headlines of the news and append to arraylist
        for (WebElement i : headlines) {
            String headline = i.findElement(By.tagName("a")).getText();
            newsHeadLines.add(headline);
        }

        //fetch the story of the news and append to arraylist
        List<WebElement> stories = driver.findElements(By.className("media__summary"));

        for (WebElement j: stories){
            String story = j.getText();
            newsStories.add(story);
        }

        display(newsHeadLines, newsStories);
    }

    public static void display(ArrayList<String> headlines, ArrayList<String> stories){

        ChromeDriver driver = new ChromeDriver();

        driver.get("c:\\Users\\HP\\Desktop\\NewsAutomation\\newsWebsite.html");

        int i = 1, j = 1;
        while (i < stories.size()){
            while (j < headlines.size()) {

                String singleHeadline = headlines.get(j);
                String singleStory = stories.get(i);

                WebElement HeadlinesDiv = driver.findElement(By.id("headlines"));
                HeadlinesDiv.sendKeys(singleHeadline);

                WebElement detailsDiv = driver.findElement(By.id("details"));
                detailsDiv.sendKeys(singleStory);

                WebElement addButton = driver.findElement(By.id("addBtn"));
                addButton.click();

                HeadlinesDiv.clear();
                detailsDiv.clear();

                j++;
                i++;
               if(j > 10){
                   break;
               }

               }
            if(i > 10){
                break;
            }
        }



    }

    public static void myWebsite(String headline , String story){
        ChromeDriver driver = new ChromeDriver();
        driver.get("c:\\Users\\HP\\Desktop\\NewsAutomation\\newsWebsite.html");

        WebElement HeadlinesDiv = driver.findElement(By.id("headlines"));
        HeadlinesDiv.sendKeys(headline);

        WebElement detailsDiv = driver.findElement(By.id("details"));
        detailsDiv.sendKeys(story);

        WebElement addButton = driver.findElement(By.id("addBtn"));
        addButton.click();

        HeadlinesDiv.clear();
        detailsDiv.clear();
    }
}
