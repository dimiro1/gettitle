// The MIT License (MIT)
//
// Copyright (c) 2016 Claudemiro
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in all
// copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
// SOFTWARE.

package br.com.ideiasuteis.gettitle;

import jodd.http.HttpBrowser;
import jodd.http.HttpRequest;
import jodd.jerry.Jerry;

/**
 * GetTitleService is the service that hold logic for
 * titles from HTML pages.
 *
 * @author claudemiro
 */
final class GetTitleService {
    /**
     * getTitle receives a url parameter and return a Response object that hoold the page title
     * @param url The HTML page url
     * @return Response
     */
    static Response getTitle(String url) {
        HttpBrowser browser = new HttpBrowser();
        HttpRequest request = HttpRequest.get(url);
        browser.sendRequest(request);

        String page = browser.getPage();
        Jerry doc = Jerry.jerry(page);

        return new Response(doc.$("title").text());
    }

    /**
     * Request is used to build the request object
     * In the AWS lambda context, a object from this class
     * is converted from a JSON representation.
     */
    static final class Request {
        private String url;

        @SuppressWarnings("unused")
        String getUrl() {
            return url;
        }

        @SuppressWarnings("unused")
        public void setUrl(String url) {
            this.url = url;
        }
    }

    /**
     * Response is used to to build the response object
     * In the AWS lambda context, a object from this class
     * is converted to a JSON representation.
     */
    static final class Response {
        private String title;

        Response(String title) {
            this.title = title;
        }

        @SuppressWarnings("unused")
        public String getTitle() {
            return title;
        }

        @SuppressWarnings("unused")
        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return "Response{" +
                    "title='" + title + '\'' +
                    '}';
        }
    }
}
