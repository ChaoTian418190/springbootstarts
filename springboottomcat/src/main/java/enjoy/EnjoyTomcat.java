package enjoy;

import enjoy.servlet.IndexServlet;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

//自己集成内置tomcat
public class EnjoyTomcat {

    private static int PORT = 8090;
    private static String CONTEX_PATH = "/enjoy";
    private static String SERVLET_NAME = "indexServlet";

    public static void main(String[] args) throws LifecycleException {

        //创建tomcat服务
        Tomcat tomcatServer = new Tomcat();
        //指定端口号
        tomcatServer.setPort(PORT);
        //是否设置自动部署
        tomcatServer.getHost().setAutoDeploy(false);
        //创建上下文
        StandardContext context = new StandardContext();
        context.setPath(CONTEX_PATH);
        //监听上下文
        context.addLifecycleListener(new Tomcat.FixContextListener());
        //tomcat容器添加StandardContext
        tomcatServer.getHost().addChild(context);
        //创建servlet
        tomcatServer.addServlet(CONTEX_PATH,SERVLET_NAME,new IndexServlet());
        //ServletUrl映射
        context.addServletMappingDecoded("/index",SERVLET_NAME);
        tomcatServer.start();
        System.out.println("tomcat 服务器启动成功...");
        //异步进行接收请求
        tomcatServer.getServer().await();
    }
}
