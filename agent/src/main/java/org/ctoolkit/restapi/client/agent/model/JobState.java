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

package org.ctoolkit.restapi.client.agent.model;

/**
 * Map reduce job state
 *
 * @author <a href="mailto:jozef.pohorelec@ctoolkit.org">Jozef Pohorelec</a>
 */
public enum JobState
{
    /**
     * The job state could not be obtained or was not specified.
     */
    UNKNOWN,

    /**
     * The job has been paused, or has not yet started.
     */
    STOPPED,

    /**
     * The job is currently running.
     */
    RUNNING,

    /**
     * The job has successfully completed.
     */
    DONE,

    /**
     * The job has failed.
     */
    FAILED,

    /**
     * The job has been explicitly cancelled.
     */
    CANCELLED,

    /**
     * Job is being cancelled
     */
    CANCELLING,

    /**
     * The job has been updated.
     */
    UPDATED,

    /* The is pending*/
    PENDING;
}
