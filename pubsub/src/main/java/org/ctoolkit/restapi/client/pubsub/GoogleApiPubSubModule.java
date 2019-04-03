/*
 * Copyright (c) 2017 Comvai, s.r.o. All Rights Reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package org.ctoolkit.restapi.client.pubsub;

import com.google.api.services.pubsub.Pubsub;
import com.google.inject.AbstractModule;
import org.ctoolkit.restapi.client.pubsub.adaptee.PubSubAdapteesModule;

/**
 * The Google Pub/Sub guice module as a default configuration.
 *
 * @author <a href="mailto:aurel.medvegy@ctoolkit.org">Aurel Medvegy</a>
 * @see PubSubAdapteesModule
 */
public class GoogleApiPubSubModule
        extends AbstractModule
{
    public static final String API_PREFIX = "pubsub";

    @Override
    protected void configure()
    {
        bind( Pubsub.class ).toProvider( PubsubProvider.class );
    }
}
