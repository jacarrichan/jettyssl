package com.jacarrichan.research.jettyssl.tools;

import org.eclipse.jetty.http.security.Password;
import org.eclipse.jetty.http.ssl.SslContextFactory;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ssl.SslSelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppContext;


/**
 * 开发调试使用的 Jetty Server
 * 
 * 
 */
public class JettyServer {

    public static void main(String[] args) throws Exception {
        // 生成keystore的OBF密码
        String[] arg = new String[1];
        arg[0] = "123456";
        Password.main(arg);
        Server server = buildNormalServer(8080, "/");
        server.start();
    }


    /**
     * 创建用于正常运行调试的Jetty Server, 以src/main/webapp为Web应用目录.
     */
    public static Server buildNormalServer(int port, String contextPath) {
        Server server = new Server(port);
        WebAppContext webContext = new WebAppContext("src/main/webapp", contextPath);
        webContext.setClassLoader(Thread.currentThread().getContextClassLoader());
        server.setHandler(webContext);
        server.setStopAtShutdown(true);
        // ---
        SslSelectChannelConnector ssl_connector = new SslSelectChannelConnector();
        String jetty_home = System.getProperty("jetty.home", ClassLoader.getSystemResource("").getPath());
        System.out.println(jetty_home);
        System.setProperty("jetty.home", jetty_home);
        ssl_connector.setPort(443);
        SslContextFactory cf = ssl_connector.getSslContextFactory();
        // 使用这个命令来生成keystore文件
        // [ keytool -keystore keystore -alias jetty -genkey -keyalg RSA]
        cf.setKeyStore(jetty_home + "jetty-keystore");
        cf.setKeyStorePassword("OBF:19iy19j019j219j419j619j8");
        cf.setKeyManagerPassword("OBF:19iy19j019j219j419j619j8");
        server.addConnector(ssl_connector);
        // ---
        return server;
    }

}
