package com.railway.labor.score.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseFilter {
	protected final Logger log = LoggerFactory.getLogger(getClass());
	protected static final Set<String> NO_NEED_LOGIN_PATHS = Collections.unmodifiableSet(new HashSet<>(  
            Arrays.asList("/", "/login.json","/favicon.ico","/error.json")));
	protected static final Set<String> ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<>(  
            Arrays.asList("/", "/login.json","/favicon.ico","/error.json")));
}
