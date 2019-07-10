/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.search.aggregations.support;

import org.elasticsearch.common.io.stream.StreamInput;
import org.elasticsearch.common.io.stream.StreamOutput;
import org.elasticsearch.common.io.stream.Writeable;

import java.io.IOException;
import java.util.Locale;

public enum ValuesSourceType implements Writeable {
    ANY,
    NUMERIC,
    BYTES,
    GEOPOINT,
    RANGE,
    GEOSHAPE;

    public static ValuesSourceType fromString(String name) {
        return valueOf(name.trim().toUpperCase(Locale.ROOT));
    }

    public static ValuesSourceType fromStream(StreamInput in) throws IOException {
        return in.readEnum(ValuesSourceType.class);
    }

    @Override
    public void writeTo(StreamOutput out) throws IOException {
        ValuesSourceType state = this;
        out.writeEnum(state);
    }

    public String value() {
        return name().toLowerCase(Locale.ROOT);
    }
}
