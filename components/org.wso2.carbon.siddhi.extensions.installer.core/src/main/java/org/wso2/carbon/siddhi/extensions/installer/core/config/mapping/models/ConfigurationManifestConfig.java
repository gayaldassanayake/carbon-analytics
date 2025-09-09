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

package org.wso2.carbon.siddhi.extensions.installer.core.config.mapping.models;

import org.wso2.carbon.siddhi.extensions.installer.core.execution.DependencyInstaller;
import org.wso2.carbon.siddhi.extensions.installer.core.execution.DependencyInstallerImpl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * The in-memory representation of the si.yaml that keeps track of the Siddhi extensions and their dependencies.
 */
// TODO: move the execution logic to the execution package\
public class ConfigurationManifestConfig {
    private final Map<String, ExtensionConfig> extensions = new HashMap<>();

//    public Map<String, ExtensionConfig> removeExtension(String extensionName) {
//        extensions.remove(extensionName);
//        return Collections.unmodifiableMap(extensions);
//    }
//
//    public Map<String, ExtensionConfig> addExtension(String extensionName, ExtensionConfig extensionConfig) {
//        // TODO: if not installed, install
//        DependencyInstaller installer = new DependencyInstallerImpl(extensionConfig);
//        extensions.put(extensionName, extensionConfig);
//        return Collections.unmodifiableMap(extensions);
//    }
}
