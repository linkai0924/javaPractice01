package ftpTools;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.OutputStream;
import java.util.Vector;

/**
 * 利用JSch包实现SFTP下载、上传文件
 *
 * Created by xiaokai on 2016/1/27.
 */
public class SftpDemoNormal {

    public static void main(String[] args) {
        try {
            sshSftp("192.168.143.114", "work", "work", 22);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sshSftp(String ip, String user, String psw, int port) throws Exception {

        Session session = null;
        Channel channel = null;
        JSch jsch = new JSch();
        if (port <= 0) {
            //连接服务器，采用默认端口
            session = jsch.getSession(user, ip);
        } else {
            //采用指定的端口连接服务器
            session = jsch.getSession(user, ip, port);
        }

        //如果服务器连接不上，则抛出异常
        if (session == null) {
            throw new Exception("session is null");
        }

        //设置登陆主机的密码
        session.setPassword(psw);//设置密码
        //设置第一次登陆的时候提示，可选值：(ask | yes | no)
        session.setConfig("StrictHostKeyChecking", "no");
        //设置登陆超时时间
        session.connect(30000);

        try {
            //创建sftp通信通道
            channel = (Channel) session.openChannel("sftp");
            channel.connect(1000);
            ChannelSftp sftp = (ChannelSftp) channel;


            //进入服务器指定的文件夹
            sftp.cd("/data");

            //列出服务器指定的文件列表
            Vector v = sftp.ls("*");
            for (int i = 0; i < v.size(); i++) {
                System.out.println(v.get(i));
            }

            //以下代码实现从本地上传一个文件到服务器，如果要实现下载，对换以下流就可以了
            OutputStream outstream = sftp.put("1.txt");
//            InputStream instream = new FileInputStream(new File("c:/print.txt"));

            byte b[] = new byte[1024];
            int n;
//            while ((n = instream.read(b)) != -1) {
//                outstream.write(b, 0, n);
//            }

            outstream.flush();
            outstream.close();
//            instream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.disconnect();
            channel.disconnect();
        }
    }


}
