/*
 * Copyright 2017 Ivo Woltring <WebMaster@ivonet.nl>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nl.ordina.route.ftp;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * FTP 2 FTP Route.
 *
 * @author Ivo Woltring
 */
@Slf4j
@Component
public class FtpToFtpRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        final String name = this.getClass().getSimpleName();


// Create a route that moves all files arriving into the `user` ftp account to the `admin` account
// make sure to log all you do
// the move should leave a copy in a backup folder on the `user` account


    }
}
