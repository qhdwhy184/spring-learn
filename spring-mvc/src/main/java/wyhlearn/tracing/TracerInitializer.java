/*
 * Copyright 2019. VMware, Inc.  All rights reserved. VMware Confidential
 */

package wyhlearn.tracing;

import io.opentracing.util.GlobalTracer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TracerInitializer {

    @PostConstruct
    public void init() {
        System.out.println("TracerInitializer begin init");
        GlobalTracer.register(Tracing.init("GlobalTracer - why test"));
    }
}
