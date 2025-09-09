/*
 * Copyright (c) 2025, WSO2 LLC. (https://www.wso2.com).
 *
 * WSO2 LLC. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.siddhi.extensions.installer.core.execution;

import org.wso2.carbon.siddhi.extensions.installer.core.config.mapping.models.ExtensionConfig;
import org.wso2.carbon.siddhi.extensions.installer.core.exceptions.ExtensionsInstallerException;
import org.wso2.carbon.siddhi.extensions.installer.core.models.enums.ExtensionAdditionStatus;
import org.wso2.carbon.siddhi.extensions.installer.core.models.enums.ExtensionInstallationStatus;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.wso2.carbon.siddhi.extensions.installer.core.util.ResponseEntityCreator.createExtensionAdditionResponse;

public class ProjectManifestManager {
    private final Map<String, ExtensionConfig> projectExtensionConfigs;
    private final Map<String, ExtensionConfig> globalExtensionConfigs;
    private DependencyInstaller dependencyInstaller;

    public ProjectManifestManager(Map<String, ExtensionConfig> globalExtensionConfigs) {
        this.globalExtensionConfigs = globalExtensionConfigs;
        this.projectExtensionConfigs = new HashMap<>();
        this.dependencyInstaller = new DependencyInstallerImpl(globalExtensionConfigs);

    }

    public Map<String, Object> addExtension(String extensionName) {
        ExtensionConfig extensionConfig = globalExtensionConfigs.get(extensionName);
        if (extensionConfig == null) {
            return createExtensionAdditionResponse(null, ExtensionAdditionStatus.INVALID_EXTENSION);
        }
        projectExtensionConfigs.put(extensionName, extensionConfig);
        return createExtensionAdditionResponse(projectExtensionConfigs, ExtensionAdditionStatus.ADDED);
    }

//    public Map<String, ExtensionConfig> removeExtension(String extensionName) {
//        extensions.remove(extensionName);
//        return Collections.unmodifiableMap(extensions);
//    }

//    private boolean isInstalled(String extensionName) throws ExtensionsInstallerException {
//        // TODO: make this class level if needed
//        DependencyRetriever retriever = new DependencyRetrieverImpl(globalExtensionConfigs);
//        Map<String, Object> extensionInfo = retriever.getExtensionStatusFor(extensionName);
//        ExtensionInstallationStatus status = (ExtensionInstallationStatus) extensionInfo.get("extensionStatus");
//        switch (status) {
//            case INSTALLED:
//            case PARTIALLY_INSTALLED:
//                return true;
//            case NOT_INSTALLED:
//                return false;
//            default:
//                throw new ExtensionsInstallerException("Extension " + extensionName + " is in an invalid state: " + status);
//        }
//    }
}
