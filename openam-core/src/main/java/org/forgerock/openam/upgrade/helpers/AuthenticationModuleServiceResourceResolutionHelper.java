/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2011 ForgeRock AS. All Rights Reserved
 *
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the License). You may not use this file except in
 * compliance with the License.
 *
 * You can obtain a copy of the License at
 * http://forgerock.org/license/CDDLv1.0.html
 * See the License for the specific language governing
 * permission and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL
 * Header Notice in each file and include the License file
 * at http://forgerock.org/license/CDDLv1.0.html
 * If applicable, add the following below the CDDL Header,
 * with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 */
package org.forgerock.openam.upgrade.helpers;

import java.util.HashMap;
import java.util.Map;

/**
 *    Authentication Module Service Resource Resolution Helper
 *
 *    Provides Lookup helper for obtaining correct path for
 *    various resource files located within the classpath in a JAR or
 *    resource directory.
 */
public class AuthenticationModuleServiceResourceResolutionHelper {

    private static Map<String, String> resourceNeighborClassNames = new HashMap<String, String>();

    private AuthenticationModuleServiceResourceResolutionHelper() {}

    /**
     *  Get Resource Neighbor Class Name
     * @return Map<string,String> of all Resource Neighbor Class Names
     */
    public static Map<String, String> getResourceNeighborClassNames() {
        return resourceNeighborClassNames;
    }

    /**
     * Load up the Defined Maps for Knowledge obtaining the Resource.
     */
    static {

        /** amAuthAD.xml **/
        resourceNeighborClassNames.put("amAuthAD.xml","com.sun.identity.authentication.modules.ad.AD");

        /** amAuthHTTPBasic.xml **/
        resourceNeighborClassNames.put("amAuthHTTPBasic.xml","com.sun.identity.authentication.modules.httpbasic.HTTPBasic");




    };


    /**
     * Obtain the Neighbor Class for the specified Resource.
     * @param resourceName
     * @return String of Found Neighbor Class.
     */
    public static String getNeighborClassName(String resourceName) {
          if ( (resourceName == null) || (resourceName.length() <= 0) )
            { return null; }
          return resourceNeighborClassNames.get(resourceName);
    }





}