/**
 * Copyright 2007-2015, Kaazing Corporation. All rights reserved.
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
package org.kaazing.gateway.resource.address.uri;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.kaazing.gateway.resource.address.networkinterface.resolution.utils.ResolutionTestUtils;

public class URIWrapperTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private static String networkInterface = ResolutionTestUtils.getLoopbackInterface();

    @Test
    public void uriUtilsMethodsBehaviorTcp127001() {
        String uriString = "tcp://127.0.0.1:8080/test?param1=val#fragment";
        URIWrapper uri = URIWrapper.create(uriString);
        assertEquals("127.0.0.1", uri.getHost());
        assertEquals("tcp", uri.getScheme());
        assertEquals("127.0.0.1:8080", uri.getAuthority());
        generalAsserts(uriString);
    }

    @Test
    public void uriUtilsMethodsBehaviorTcpLoopbackBrackets() {
        String uriString = "tcp://[@" + networkInterface +
                "]:8080/test?param1=val#fragment";
        thrown.expect(IllegalArgumentException.class);
        URIWrapper.create(uriString);
    }

    /**
     * Method performing general asserts
     * @param uri
     */
    private void generalAsserts(String uri) {
        assertEquals("fragment", URIUtils.getFragment(uri));
        assertEquals("/test", URIUtils.getPath(uri));
        assertEquals("param1=val", URIUtils.getQuery(uri));
        assertEquals(8080, URIUtils.getPort(uri));
        assertNull(URIUtils.getUserInfo(uri));
    }
}
