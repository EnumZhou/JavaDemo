package com.mercury.gemeOnlineShop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.gemeOnlineShop.beans.Platform;
import com.mercury.gemeOnlineShop.daos.PlatformDao;
import com.mercury.gemeOnlineShop.http.Response;

@Service
public class PlatformService {
	@Autowired
	private PlatformDao platformDao;
	
	public Response save(Platform platform) {
		try {
			platformDao.save(platform);
			return new Response(true);
		}
		catch(Exception e) {
			return new Response(false);
		}
	}
	
	public List<Platform> getAll() {
		return platformDao.findAll();
	}
	

}
