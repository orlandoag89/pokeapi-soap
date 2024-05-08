package com.example.demosoap.utils;

public interface IToInner<I, O> {
	
	I toInner(O outer);
}
