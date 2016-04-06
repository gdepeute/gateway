/**
 * Copyright 2007-2016, Kaazing Corporation. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kaazing.gateway.transport.ssl;

import org.kaazing.gateway.transport.Transport;
import org.kaazing.gateway.transport.TransportFactorySpi;

import java.util.Collection;
import java.util.Map;

import java.util.Collections;

public final class SslTransportFactorySpi extends TransportFactorySpi {

    private final Collection<String> SSL_SCHEMES = Collections.singleton("ssl");

    @Override
    public String getTransportName() {
        return "ssl";
    }

    @Override
    public Collection<String> getSchemeNames() {
        return SSL_SCHEMES;
    }

    @Override
    public Transport newTransport(Map<String, ?> configuration) {
        return new SslTransport();
    }

}
