package com.microservice.zuulFilters;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.stream.Collectors;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.netflix.zuul.http.ServletInputStreamWrapper;

@Component
public class CipherPreFilter extends ZuulFilter{
	private static final String Algoritmo = "AES/CBC/PKCS5Padding";
    private static final String Llave = "YourSecretKey";
    private static final String Vector = "YourInitVector";

	@Override
	public boolean shouldFilter() {
		
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
		try {
	        String informacion = RequestContext.getCurrentContext().getRequest().getReader().lines().collect(Collectors.joining(System.lineSeparator()));
	        String informacionEncriptada = encriptacion(informacion, Llave, Vector, Algoritmo);

	        RequestContext.getCurrentContext().setRequest(new HttpServletRequestWrapper(RequestContext.getCurrentContext().getRequest()) {
	            @Override
	            public ServletInputStream getInputStream() throws IOException {
	                return new ServletInputStreamWrapper(informacionEncriptada.getBytes(StandardCharsets.UTF_8));
	            }
	            @Override
	            public int getContentLength() {
	                return informacionEncriptada.getBytes(StandardCharsets.UTF_8).length;
	            }
	        });

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return null;
	}

	private String encriptacion(String info, String llave, String vector, String algoritmo) {
	    try {
	        SecretKeySpec espLlave = new SecretKeySpec(llave.getBytes(StandardCharsets.UTF_8), "AES");
	        IvParameterSpec ivParametroEsp = new IvParameterSpec(vector.getBytes(StandardCharsets.UTF_8));
	        Cipher encriptado = Cipher.getInstance(algoritmo);
	        encriptado.init(Cipher.ENCRYPT_MODE, espLlave, ivParametroEsp);

	        byte[] infoEncrptada = encriptado.doFinal(info.getBytes(StandardCharsets.UTF_8));
	        return Base64.getEncoder().encodeToString(infoEncrptada);
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	@Override
	public String filterType() {
		
		return "pre";
	}

	@Override
	public int filterOrder() {
		
		return 1;
	}

}
