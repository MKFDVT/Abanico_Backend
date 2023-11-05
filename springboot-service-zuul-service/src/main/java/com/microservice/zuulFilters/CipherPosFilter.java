package com.microservice.zuulFilters;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class CipherPosFilter extends ZuulFilter{
	private static final String Algoritmo = "AES/CBC/PKCS5Padding";
    private static final String Llave = "YourSecretKey";
    private static final String Vector = "YourInitVector";

	@Override
	public boolean shouldFilter() {
		
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
		String informacion = RequestContext.getCurrentContext().getResponseBody();

        String infoDesencrptada = desencrptador(informacion, Llave, Vector, Algoritmo);
        RequestContext.getCurrentContext().setResponseBody(infoDesencrptada);

        return null;
    }


    private String desencrptador(String info, String llave, String vector, String algoritmo) {
        try {
            SecretKeySpec espLlave = new SecretKeySpec(llave.getBytes(StandardCharsets.UTF_8), "AES");
            IvParameterSpec ivParametroEsp = new IvParameterSpec(vector.getBytes(StandardCharsets.UTF_8));
            Cipher encriptado = Cipher.getInstance(algoritmo);
            encriptado.init(Cipher.DECRYPT_MODE, espLlave, ivParametroEsp);

            byte[] encrptado = Base64.getDecoder().decode(info);
            byte[] desencrptado = encriptado.doFinal(encrptado);

            return new String(desencrptado, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

	@Override
	public String filterType() {
		
		return "pos";
	}

	@Override
	public int filterOrder() {
		
		return 2;
	}

}
