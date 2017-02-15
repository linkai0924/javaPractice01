package leader.dao;

import com.alibaba.fastjson.JSON;
import leader.bean.User;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

@Component
public class UserDao implements AbstractDAO<User> {


//    public static void main(String[] args) {
//        try {
//            UserDao userDao = new UserDao();
//            userDao.writeFile("");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

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
}
