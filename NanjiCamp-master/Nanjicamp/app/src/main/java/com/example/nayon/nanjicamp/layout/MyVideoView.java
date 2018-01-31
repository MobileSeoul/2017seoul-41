package com.example.nayon.nanjicamp.layout;


import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;

import java.io.IOException;

public class MyVideoView extends TextureView implements TextureView.SurfaceTextureListener {

    private MediaPlayer mMediaPlayer = new MediaPlayer();
    private Uri mSource;
    private MediaPlayer.OnCompletionListener mCompletionListener;
    private boolean isLooping = true;
    private boolean isSeekTo = false;
    private Surface surface;
    private boolean isPlayed = false;

    public MyVideoView(Context context) {
        this(context, null, 0);
    }

    public MyVideoView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyVideoView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setSurfaceTextureListener(this);
    }

    public void setSource(Uri source) {
        mSource = source;
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener listener) {
        mCompletionListener = listener;
    }

    public void setIsPlayed(boolean isPlayed){
        this.isPlayed = isPlayed;
    }

    public void setLooping(boolean looping) {
        isLooping = looping;
    }

    public void setSeekTo(boolean seekTo){
        isSeekTo = seekTo;
    }

    @Override
    protected void onDetachedFromWindow() {
        // release resources on detach
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
        super.onDetachedFromWindow();
    }

    public void setStart(){
        try {
            if(isPlayed==false) {
                isPlayed = true;
                //mMediaPlayer.setOnBufferingUpdateListener(this);
                //mMediaPlayer.setOnErrorListener(this);
                mMediaPlayer.setLooping(isLooping);
                mMediaPlayer.setDataSource(getContext(), mSource);
                Log.e("nayong", "setStart: " + mSource);
                mMediaPlayer.prepare();
                if (isSeekTo == true) {
                    mMediaPlayer.seekTo(1000);
                    isSeekTo = false;
                } else {
                    mMediaPlayer.start();
                }
            }else{
                mMediaPlayer.start();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
            mMediaPlayer.reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setPause(){
        try {
            if(mMediaPlayer.isPlaying()){
                mMediaPlayer.pause();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
            mMediaPlayer.reset();
        }
    }

    public void setStop(){
        try {
            if(mMediaPlayer.isPlaying()){
                mMediaPlayer.seekTo(0);
//                mMediaPlayer.stop();
//                mMediaPlayer.release();
//                mMediaPlayer = null;
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
            mMediaPlayer.reset();
        }
    }

    /*
         * TextureView.SurfaceTextureListener
         */
    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int width, int height) {

        surface = new Surface(surfaceTexture);
        mMediaPlayer.setOnCompletionListener(mCompletionListener);
        mMediaPlayer.setSurface(surface);
        setStart();
//        try {
//            mMediaPlayer.setOnCompletionListener(mCompletionListener);
//            //mMediaPlayer.setOnBufferingUpdateListener(this);
//            //mMediaPlayer.setOnErrorListener(this);
//            mMediaPlayer.setLooping(isLooping);
//            mMediaPlayer.setDataSource(getContext(), mSource);
//            mMediaPlayer.setSurface(surface);
//            mMediaPlayer.prepare();
//            if(isSeekTo==true){
//                mMediaPlayer.seekTo(1000);
//            }else{
//                mMediaPlayer.start();
//            }
//            isSeekTo = false;
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//        } catch (SecurityException e) {
//            e.printStackTrace();
//        } catch (IllegalStateException e) {
//            e.printStackTrace();
//            mMediaPlayer.reset();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {}

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        surface.release();
        return true;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
    }

}