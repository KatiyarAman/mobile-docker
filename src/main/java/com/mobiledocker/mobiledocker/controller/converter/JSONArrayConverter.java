package com.mobiledocker.mobiledocker.controller.converter;

import com.fasterxml.jackson.databind.util.StdConverter;


import org.json.JSONArray;

import java.util.List;

public class JSONArrayConverter extends StdConverter<JSONArray, List<Object>> {
   

	@Override
	public List<Object> convert(JSONArray value) {
		// TODO Auto-generated method stub
		return null;
	}
}
