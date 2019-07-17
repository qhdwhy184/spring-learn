/*
 * Copyright 2019. VMware, Inc.  All rights reserved. VMware Confidential
 */

package wyhlearn.tracing;

import io.jaegertracing.Configuration;
import io.jaegertracing.Configuration.ReporterConfiguration;
import io.jaegertracing.Configuration.SamplerConfiguration;
import io.jaegertracing.internal.JaegerTracer;
import io.jaegertracing.internal.samplers.ConstSampler;
import io.opentracing.Scope;
import io.opentracing.SpanContext;
import io.opentracing.Tracer;
import io.opentracing.propagation.Format;
import io.opentracing.propagation.TextMap;
import io.opentracing.propagation.TextMapExtractAdapter;
import io.opentracing.tag.Tags;
import okhttp3.Request;

import javax.ws.rs.core.MultivaluedMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class Tracing {
    private Tracing() {
    }

    public static JaegerTracer init(String service) {
        SamplerConfiguration samplerConfig = SamplerConfiguration.fromEnv()
                .withType(ConstSampler.TYPE)
                .withParam(1);

        ReporterConfiguration reporterConfig = ReporterConfiguration.fromEnv()
                .withSender(new Configuration.SenderConfiguration()
                                                .withAgentHost("10.117.4.117").withAgentPort(6831))
                .withLogSpans(true);

        Configuration config = new Configuration(service)
                .withSampler(samplerConfig)
                .withReporter(reporterConfig);

        return config.getTracer();
    }
}
