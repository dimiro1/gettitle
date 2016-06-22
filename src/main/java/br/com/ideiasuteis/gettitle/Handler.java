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

import com.amazonaws.services.lambda.runtime.Context;

/**
 * Handler is the entrypoint for AWS Lambda
 *
 * @author claudemiro
 */
@SuppressWarnings("unused")
public class Handler {
    /**
     * handle receives an event from AWS lambda service and handle the request.
     * It is important to mention that this function should be used in a Request Response lambda event.
     *
     * @param request A GetTitleService.Request object
     * @param context A Aws lambda Context object
     * @return A GetTitleService.Response object
     */
    public GetTitleService.Response handle(GetTitleService.Request request, Context context) {
        return GetTitleService.getTitle(request.getUrl());
    }
}
