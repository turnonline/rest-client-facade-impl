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

package org.ctoolkit.restapi.client.agent.adaptee;

import org.ctoolkit.api.agent.model.PropertyMetaData;
import org.ctoolkit.restapi.client.Identifier;
import org.ctoolkit.restapi.client.RequestCredential;
import org.ctoolkit.restapi.client.adaptee.ListExecutorAdaptee;
import org.ctoolkit.restapi.client.adapter.AbstractGoogleClientAdaptee;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author <a href="mailto:jozef.pohorelec@ctoolkit.org">Jozef Pohorelec</a>
 */
public class GenericJsonPropertyMetaDataAdaptee
        extends AbstractGoogleClientAdaptee<CustomizedCtoolkitAgent>
        implements ListExecutorAdaptee<PropertyMetaData>
{
    @Inject
    public GenericJsonPropertyMetaDataAdaptee( Provider<CustomizedCtoolkitAgent> client )
    {
        super( client );
    }

    @Override
    public Object prepareList( @Nullable Identifier parentKey ) throws IOException
    {
        checkNotNull( parentKey );
        return client().metadata().kind().property().list( parentKey.getString() );
    }

    @Override
    @SuppressWarnings( "unchecked" )
    public List<PropertyMetaData> executeList( @Nonnull Object request,
                                               @Nullable Map<String, Object> parameters,
                                               @Nullable Locale locale,
                                               @Nullable Integer start,
                                               @Nullable Integer length,
                                               @Nullable String orderBy,
                                               @Nullable Boolean ascending )
            throws IOException
    {
        checkNotNull( request );

        RequestCredential credential = new RequestCredential();
        credential.fillInFrom( parameters, true );

        fill( request, parameters );
        return ( ( CustomizedCtoolkitAgent.Metadata.Kind.Property.List ) request ).execute( credential ).getItems();
    }
}
