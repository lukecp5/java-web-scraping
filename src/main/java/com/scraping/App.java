package com.scraping;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */

    public static void main(String[] args) {

        Document doc;
        try {

            doc = Jsoup.connect("https://scrapeme.live/shop/").get();

            // get title of the page
            String title = doc.title();
            String linkRel = doc.select("link[rel=stylesheet]").attr("href");
            System.out.println("Title: " + title);
            System.out.println("CSS Link: " + linkRel);
            // get all links
            Elements links = doc.select("a[href]");
            Elements images = doc.select("img[src]");
            Elements pokemon = doc.select("a > h2");
            for (Element link : links) {

                // get the value from href attribute
                System.out.println("\nLink : " + link.attr("href"));
                System.out.println("Text : " + link.text());
            }
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            for (Element pokemonName : pokemon) {
                System.out.println("Pokemon Name: " + pokemonName.text());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
