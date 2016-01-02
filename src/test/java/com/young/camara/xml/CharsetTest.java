package com.young.camara.xml;

import java.nio.charset.Charset;

public class CharsetTest {

	public static void main(String[] args) {
		System.out.println(Charset.isSupported("utf-8"));
		System.out.println(Charset.forName("utf-8"));
	}
}
