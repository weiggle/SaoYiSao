package github.weiggle.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import github.weiggle.com.saoyisao.R;

/**
 * Created by Administrator on 2016/5/8.
 */
public class SaoYiSaoWidget  extends FrameLayout {

    private Paint mPaintCircle;
    private Paint mPaintShade;
    private int width,height;
    private Shader mShader;
    private int startAngle;
    private Matrix mMatrix;



    public SaoYiSaoWidget(Context context) {
        this(context,null);
    }

    public SaoYiSaoWidget(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SaoYiSaoWidget(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


        initView(context);
        initPaint();
        mHandler.post(mRunnable);
    }

    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            startAngle = startAngle +1;
            mMatrix = new Matrix();
            mMatrix.postRotate(startAngle,width/2,height/2);
            invalidate();
            mHandler.postDelayed(this,60);
        }
    };

    private void initView(Context context){
        width = context.getResources().getDisplayMetrics().widthPixels;
        height = context.getResources().getDisplayMetrics().heightPixels;
        this.setBackgroundResource(R.drawable.bg);

    }


    private void initPaint(){
        mPaintCircle = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintCircle.setStyle(Paint.Style.STROKE);
        mPaintCircle.setStrokeWidth(3);
        mPaintCircle.setColor(Color.parseColor("#A1A1A1A1"));

        mPaintShade = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintShade.setColor(Color.parseColor("#FF6666"));
        mShader = new SweepGradient(width/2,height/2,Color.TRANSPARENT,Color.parseColor("#AAAAAAAA"));
        mPaintShade.setShader(mShader);
        mMatrix = new Matrix();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(width,height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(width/2,height/2,width/6,mPaintCircle);
        canvas.drawCircle(width/2,height/2,2*width/6,mPaintCircle);
        canvas.drawCircle(width/2,height/2,width/2,mPaintCircle);

        canvas.concat(mMatrix);

        canvas.drawCircle(width/2,height/2,width/2,mPaintShade);
    }
}
