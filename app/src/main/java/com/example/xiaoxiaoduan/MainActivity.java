package com.example.xiaoxiaoduan;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /***确定取消消息框***/
    private static final int DIALOG_0 = 1;
    /***多个按钮信息框***/
    private static final int DIALOG_1 = 2;
    /***列表框***/
    private static final int DIALOG_2 = 3;
    /***进度条框***/
    private static final int DIALOG_3 = 4;
    /***单项列表选择框***/
    private static final int DIALOG_4 = 5;
    /***多项列表选择框***/
    private static final int DIALOG_5 = 6;
    /***自定义布局***/
    private static final int DIALOG_6 = 7;
    /***读取进度框***/
    private static final int DIALOG_7 = 8;

    private static final int MAX_PROGRESS = 100;
    private ProgressDialog mProgressDialog = null;

    /***1.final修饰的类不能被继***/
    /***2.Sting就是一个被final修饰的类，我们只能用，不用继承***/
    /***3.final不仅可以修饰类，还可以修饰变量，被final修饰的变量就是一个常量，只能赋值一次***/
    /***4.注意final和finally的区别，final是修饰类或者变量，finally是在异常处理中使用，如：try{ }catch（）{}finally{}中，finally的作用一般用于必须处理的事情，如关闭连接***/
    /**
     * --------分割线--------
     **/
    final String[] Items = {"item0", "item1", "item2", "item3", "item4", "item5", "item6"};
    int mSingleChoiceID = -1;
    ArrayList<Integer> MultiChoiceID = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button0 = (Button) findViewById(R.id.Button0);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreatDialog(DIALOG_0);
            }
        });
        Button button1 = (Button) findViewById(R.id.Button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreatDialog(DIALOG_1);
            }
        });
        Button button2 = (Button) findViewById(R.id.Button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {CreatDialog(DIALOG_2);
            }
        });
        Button button3 = (Button) findViewById(R.id.Button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {CreatDialog(DIALOG_3);
            }
        });
        Button button4 = (Button) findViewById(R.id.Button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {CreatDialog(DIALOG_4);
            }
        });
        Button button5 = (Button) findViewById(R.id.Button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {CreatDialog(DIALOG_5);
            }
        });
        Button button6 = (Button) findViewById(R.id.Button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {CreatDialog(DIALOG_6);
            }
        });
        Button button7 = (Button) findViewById(R.id.Button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {CreatDialog(DIALOG_7);
            }
        });

    }

    public void CreatDialog(int id) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        switch (id) {
            case DIALOG_0:
                builder.setTitle("你确定要离开吗？");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        /***这里添加点击确定按钮后的逻辑***/
                        Toast.makeText(MainActivity.this, "你点击了确定", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNeutralButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        /***这里添加点击取消按钮后的逻辑***/
                        Toast.makeText(MainActivity.this, "你点击了取消", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case DIALOG_1:
                builder.setTitle("这个是多个按钮信息框");
                builder.setPositiveButton("好", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "你点击了好", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNeutralButton("差", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "你点击差", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("一般", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "你点击了一般", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case DIALOG_2:
                builder.setTitle("列表选择框");
                builder.setItems(Items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //点击后弹出窗口选择了第几项
                        Toast.makeText(MainActivity.this,"你选择的id为"+i,Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case  DIALOG_3:
                mProgressDialog = new ProgressDialog(this);
                mProgressDialog.setTitle("进度条窗口");
                mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                mProgressDialog.setMax(MAX_PROGRESS);
                mProgressDialog.setButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //这里添加点击后的逻辑
                    }
                });
                mProgressDialog.setButton2("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //这里添加点击后的逻辑
                    }
                });
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int i = 0;
                        while (i < 100) {
                            try {
                                Thread.sleep(200);
                                // 更新进度条的进度,可以在子线程中更新进度条进度
                                mProgressDialog.incrementProgressBy(1);
                                // dialog.incrementSecondaryProgressBy(10)//二级进度条更新方式
                                i++;
                            } catch (Exception e) {
                            }
                        }
                        // 在进度条走完时删除
                        mProgressDialog.dismiss();
                    }
                }).start();
                mProgressDialog.show();
                return;
            case DIALOG_4:
                mSingleChoiceID = -1;
                builder.setTitle("单项选择");
                builder.setSingleChoiceItems(Items, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mSingleChoiceID = i;
                        Toast.makeText(MainActivity.this,"你选择的id为"+i,Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (mSingleChoiceID >0){
                            Toast.makeText(MainActivity.this,"你选择的id为"+mSingleChoiceID,Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //取消
                        Toast.makeText(MainActivity.this, "点击了取消", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case DIALOG_5:
                MultiChoiceID.clear();
                builder.setTitle("多项选择");
                builder.setMultiChoiceItems(Items, new boolean[]{false, false, false, false, false, false, false}, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        if (b){
                            MultiChoiceID.add(i);
                            Toast.makeText(MainActivity.this, "你选择的id为"+i, Toast.LENGTH_SHORT).show();
                        }else {
                            MultiChoiceID.remove(b);
                        }
                    }
                });
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                   String str = "";
                   int size = MultiChoiceID.size();
                   for (i = 0; i<size; i++)
                   {
                       str+=Items[MultiChoiceID.get(i)]+",";
                   }
                        Toast.makeText(MainActivity.this, "你选择的是"+str, Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "你点击了取消", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case DIALOG_6:
                LayoutInflater factory = LayoutInflater.from(this);
                final View textEntryView = factory.inflate(R.layout.nameone,null);
                builder.setTitle("自定义布局");
                builder.setView(textEntryView);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText userName = (EditText)textEntryView.findViewById(R.id.etUserName);
                        EditText password = (EditText)textEntryView.findViewById(R.id.etPassWord);
                        Toast.makeText(MainActivity.this, "姓名："+userName.getText().toString()+"密码："+password.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "点击了取消", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case DIALOG_7:
                builder.setTitle("读取进度框");
                mProgressDialog = new ProgressDialog(this);
                mProgressDialog.setTitle("读取ing");
                mProgressDialog.setMessage("正在读取中请稍候");
                mProgressDialog.setIndeterminate(true);
                mProgressDialog.setCancelable(true);
                mProgressDialog.show();
                return;
        }
        builder.show();
    }
}

