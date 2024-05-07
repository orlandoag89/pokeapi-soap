package com.example.demosoap.utils;

public interface IMapper<I, O> {
	
	I toInner(O outer);
	
	O toOuter(I inner);

}
