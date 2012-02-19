/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.karaf.webconsole.osgi.core.bundle.list.link;

import org.apache.karaf.webconsole.osgi.core.bundle.list.BundlePage;
import org.apache.wicket.RequestCycle;
import org.apache.wicket.Session;
import org.apache.wicket.authorization.Action;
import org.apache.wicket.authorization.strategies.role.annotations.AuthorizeAction;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;

/**
 * Bundle stop link.
 */
@AuthorizeAction(action = Action.RENDER, roles = {"admin"})
public class StopLink extends Link<Bundle> {

    private static final long serialVersionUID = 1L;

    public StopLink(String id, IModel<Bundle> model) {
        super(id, model);}

    @Override
    public void onClick() {
        Bundle bundle = getModelObject();

        try {
            bundle.stop();
            Session.get().info(getLocalizer().getString("bundle.stop", this, getModel()));
        } catch (BundleException e) {
            Session.get().error(getLocalizer().getString("bundle.stop.fail", this, Model.of(e)));
        }
        RequestCycle.get().setResponsePage(BundlePage.class);
    }

}
