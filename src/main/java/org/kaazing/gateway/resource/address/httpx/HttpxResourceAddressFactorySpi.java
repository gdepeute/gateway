/**
 * Copyright (c) 2007-2014 Kaazing Corporation. All rights reserved.
 * 
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.kaazing.gateway.resource.address.httpx;


import static org.kaazing.gateway.resource.address.ResourceFactories.changeSchemeOnly;

import org.kaazing.gateway.resource.address.ResourceFactory;
import org.kaazing.gateway.resource.address.http.HttpResourceAddressFactorySpi;

public class HttpxResourceAddressFactorySpi extends HttpResourceAddressFactorySpi {

    private static final String SCHEME_NAME = "httpx";
    private static final ResourceFactory TRANSPORT_FACTORY = changeSchemeOnly("wsn");

    static final String PROTOCOL_NAME = "x-kaazing-handshake";

    @Override
    public String getSchemeName() {
        return SCHEME_NAME;
    }

    @Override
    protected ResourceFactory getTransportFactory() {
        return TRANSPORT_FACTORY;
    }

    @Override
    protected String getProtocolName() {
        return PROTOCOL_NAME;
    }

}
