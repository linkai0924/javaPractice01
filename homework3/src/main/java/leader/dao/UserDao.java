package leader.dao;

import com.alibaba.fastjson.JSON;
import leader.bean.User;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URL;

@Component
public class UserDao implements AbstractDAO<User> {


    @Override
    public User selectDomainObj(String userName) {
        try {
            return readFile(userName);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean createDomainObj(User user) {
        try {
            writeFile(JSON.toJSONString(user));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private void writeFile(String str) throws IOException {
        URL filePath = this.getClass().getResource("/");
        File file = new File(filePath.getPath() + "userdata.txt");// 指定要写入的文件
        if (!file.exists()) {// 如果文件不存在则创建
            file.createNewFile();
        }
        // 获取该文件的缓冲输出流
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));//true表示追加
        bufferedWriter.write(str); // 写入信息
        bufferedWriter.newLine();// 表示换行
        bufferedWriter.flush();// 清空缓冲区
        bufferedWriter.close();// 关闭输出流
    }

    private User readFile(String userName) throws IOException {
        URL filePath = this.getClass().getResource("/");
        File file = new File(filePath.getPath() + "userdata.txt");
        if (file.isFile() && file.exists()) { // 判断文件是否存在
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");// 考虑到编码格式
            BufferedReader bufferedReader = new BufferedReader(read);
            String lineTxt = null;
            while ((lineTxt = bufferedReader.readLine()) != null) {
                User user = JSON.toJavaObject(JSON.parseObject(lineTxt), User.class);
                if (user.getUserName().equals(userName)) {
                    return user;
                }
            }
            bufferedReader.close();
            read.close();
        }
        return null;
    }
}
