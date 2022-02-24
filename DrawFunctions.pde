void characterDraw(int frameRateInput)
{
  //background(0);


  swordweilderdartattack.DisplayAnimation(200,200,frameRateInput,true);
  if(swordweilderdartattack.Done()==true)
  {
    swordweilderdie.DisplayAnimation(200,200,frameRateInput,true);
    if(swordweilderdie.Done()==true)
    {
      //swordweilderdartattack.Reset();
      swordweilderdie.Reset();
    }
    
  }
}

void backgroundDraw()
{
  image(photo, 0, 0);
  
  if(largeLightning.Running()==false)
  {
    lightningTrigger1=(int)random(100);
    largeLightning.DisplayStatic(200,620);
  }  
  if(smallLightning.Running()==false)
  {
    lightningTrigger2=(int)random(100);
    smallLightning.DisplayStatic(1700,680);
  }

  if(distantLightning.Running()==false)
  {
    lightningTrigger3=(int)random(100);
    distantLightning.DisplayStatic(815,475);
  }
  if(bubbleMaker.Running()==false)
  {
    lightningTrigger4=(int)random(100);
    bubbleMaker.DisplayStatic(1100,800);
  }
  if(bubbleMaker2.Running()==false)
  {
    lightningTrigger5=(int)random(70);
    bubbleMaker2.DisplayStatic(1080,790);
  }
  if(bubbleMaker3.Running()==false)
  {
    lightningTrigger6=(int)random(90);
    bubbleMaker3.DisplayStatic(1120,790);
  }
    
  
  if(lightningTrigger1==1)
  {
    largeLightning.DisplayAnimation(200,620,6);
  }
  
  if(lightningTrigger2==2)
  {
    smallLightning.DisplayAnimation(1700,680,6);
  }

  if(lightningTrigger3==3)
  {
    distantLightning.DisplayAnimation(815,475,6);
  }
  
  if(lightningTrigger4==4)
  {
    bubbleMaker.DisplayAnimation(1100,800,4);
  }
  if(lightningTrigger5==5)
  {
    bubbleMaker2.DisplayAnimation(1080,790,4);
  }
  if(lightningTrigger6==6)
  {
    bubbleMaker3.DisplayAnimation(1120,790,4);
  }

}





