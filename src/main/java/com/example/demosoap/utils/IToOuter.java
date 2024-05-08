package com.example.demosoap.utils;

public interface IToOuter<I, O> {
	
	O toOuter(I inner);

}
