package com.mobiledocker.mobiledocker;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import java.io.File;
import com.mobiledocker.mobiledocker.Dao.GenericRepository;
import com.mobiledocker.mobiledocker.DaoImpl.BookUserDaoImpl;
import com.mobiledocker.mobiledocker.DaoImpl.CityDaoImpl;
import com.mobiledocker.mobiledocker.DaoImpl.CountryDaoImpl;
import com.mobiledocker.mobiledocker.DaoImpl.GenricRepositroyImpl;
import com.mobiledocker.mobiledocker.serviceImpl.MobileWareHouseDaoServiceImpl;
//@EntityScan( basePackages = {"com.mobiledocker.mobiledocker.entity"})
@SpringBootApplication

@ComponentScan(basePackages={"com.mobiledocker.mobiledocker.entity","com.mobiledocker.mobiledocker.controller","com.mobiledocker.mobiledocker.util"
		,"com.mobiledocker.mobiledocker.repository","com.mobiledocker.mobiledocker.service","com.mobiledocker.mobiledocker.serviceImpl",
		"com.mobiledocker.mobiledocker.DaoImpl","com.mobiledocker.mobiledocker.Dao","com.mobiledocker.mobiledocker"})
@Configuration
@EnableJpaRepositories(basePackages="com.mobiledocker.mobiledocker.repository",basePackageClasses = {CityDaoImpl.class,CountryDaoImpl.class,BookUserDaoImpl.class, GenricRepositroyImpl.class})

public class MobileDockerApplication {
	public static void main(String[] args) {
		//new File(MobileWareHouseDaoServiceImpl.uploadDirectory).mkdir();
		SpringApplication.run(MobileDockerApplication.class, args);
	}
	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
