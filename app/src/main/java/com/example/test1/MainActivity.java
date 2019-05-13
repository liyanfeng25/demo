package com.example.test1;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        initData();
        int a=test(4);
        Log.i("test", "onCreate: "+a);
    }

    private int test(int age) {
        if(age==1){
            return 10;
        }else {
            return test(age-1)+2;
        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    private void initData() {
        try {
            Class c=Class.forName("com.example.test1.TestBean");
//            Field[] fields = c.getDeclaredFields();
//            StringBuffer sb = new StringBuffer();
//            sb.append(Modifier.toString(c.getModifiers()) + " class " + c.getSimpleName() + "{\n");
//
//            // 遍历每一个属性
//            for (Field field : fields) {
//                sb.append("\t");// 空格
//                sb.append(Modifier.toString(field.getModifiers()) + " ");// 获得属性的修饰符，例如public，static等等
//                sb.append(field.getType().getSimpleName() + " ");// 属性的类型的名字
//                sb.append(field.getName() + ";\n");// 属性的名字+回车
//            }
//            sb.append("}\n");
//            Log.i("initData", "initData: ++++++++++++++++"+sb);

            // 获取所有的方法
            Method[] ms = c.getDeclaredMethods();
            //遍历输出所有方法
            for (Method method : ms) {
                //获取方法所有参数
                Parameter[] parameters = method.getParameters();
                String params = "";
                if (parameters.length > 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (Parameter parameter : parameters) {
                        stringBuffer.append(parameter.getType().getSimpleName() + " " + parameter.getName() + ",");
                    }
                    //去掉最后一个逗号
                    params = stringBuffer.substring(0, stringBuffer.length() - 1);
                }
                Log.i("initData", "initData: ++++++++++++++++"+Modifier.toString(method.getModifiers())
                        + " " + method.getReturnType().getSimpleName()
                        + " " + method.getName()
                        + " (" +params  + ")");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void onClick(View view) {
        Log.e("TAG", "onClick: _________________"+System.currentTimeMillis());
    }
}
