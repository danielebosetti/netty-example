package server;

import io.netty.channel.ChannelHandlerContext;

public class SendThread extends Thread {

  private ChannelHandlerContext ctx;

  public SendThread(ChannelHandlerContext ctx) {
    this.ctx = ctx;
  }
  
  @Override
  public void run() {
    System.out.println("start SendThread on ctx="+ctx);
    for (int i=0;i<10;i++) {
      try {
        sleep(2000L);
        ctx.writeAndFlush("srv>::: hello-msg-"+ i + ":::\n");
      } catch (Exception e) { 
        e.printStackTrace(System.out);
      }
    }
  }
  

}
