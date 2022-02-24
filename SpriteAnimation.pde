
class SpriteAnimation
{
    int frameNumberAll;
    String nameAll;
    int counter;
    boolean finished;
    int howLongI;
    boolean howLongIBool;
    int movePos;
    int movePosCounter;
    boolean isReturning;
    boolean attacking;
    boolean delayDone;
    boolean complete;
    
    SpriteAnimation(int frameNumber, String name)
    {
        frameNumberAll=frameNumber;
        nameAll=name;
        counter=0;
        finished=false;
        howLongI=0;
        howLongIBool=false;
        movePosCounter=0;
        attacking=false;
        delayDone=false;
        complete=false;
        
    }
    
    PImage[] imageMatrix = new PImage[30];
    void ResetMove()
    {
        movePosCounter=0;
        
        isReturningOut=false;
        isReturning=false;
        delayDone=false;
        complete=false;
    }
    void Initialize(int sizeX, int sizeY)
    {
        for(int i=0; i<frameNumberAll; i=i+1)
        {
            PImage temp;
            temp=loadImage(nameAll+""+i+".png");
            temp.resize(sizeX,sizeY);
            imageMatrix[i]=temp;
            
        }
    }
    //work on the below method
    boolean DisplayFirstFrame(int posX, int posY, int howLong)
    {
        if(howLongI<howLong)
        {
            image(imageMatrix[0],posX,posY);
            howLongI++;
            howLongIBool=false;
        }
        else
        {
            howLongI=0;
            howLongIBool=true;
            
        }
        return howLongIBool;
        
    }


    
    void Move(int startX, int endX, int posY, int speed, boolean returning, SpriteAnimation using)
    {
        
        if(startX<=endX)
        {
            if(movePos<=endX && !isReturning)
            {
                this.movePosCounter+=speed;
                this.movePos=startX+movePosCounter;
            }
            else if(returning)
            {
        
                isReturning=false;
                if(!isReturning)
                {
                    attacking=true;
                    if(this.delayDone==false)
                    {
                        delay(1000);
                        this.delayDone=true;
                    }
                    using.DisplayAnimation(endX,posY,6,true);
                    
                    if(using.Done())
                    {
                        attacking=false;
                        isReturning=true;
                    }
                }
                if(movePos>=startX && isReturning)
                {
                    this.movePosCounter-=speed;
                    this.movePos=startX+movePosCounter;
                }
                if(movePos==startX && isReturning)
                {
                    this.complete=true;
                }

                

            }
        }
        else if(startX>=endX)
        {
            if(movePos>endX && !isReturning)
            {
                this.movePosCounter+=speed;
                this.movePos=startX-movePosCounter;
            }
            else if(returning)
            {
        
                isReturning=false;
                if(!isReturning)
                {
                    attacking=true;
                    if(this.delayDone==false)
                    {
                        delay(1000);
                        this.delayDone=true;
                    }
                    using.DisplayAnimation(endX,posY,6,true);
                    
                    if(using.Done())
                    {
                        attacking=false;
                        isReturning=true;
                    }
                }
                if(movePos<=startX && isReturning)
                {
                    this.movePosCounter-=speed;
                    this.movePos=startX+movePosCounter;
                }
                if(movePos==startX && isReturning)
                {
                    this.complete=true;
                }
            }
        }

        if(attacking==false)
        {
        if(counter==0){image(imageMatrix[counter],movePos,posY);}
        else{image(imageMatrix[counter-1],movePos,posY);}
        if((float)frameCount%6==0)
        {
            if(counter<frameNumberAll)
            {
                counter++;
            }
            else
            {
                counter=0;
                
            }
        }
        }
        
    }
    
    
    

    void DisplayAnimation(int posX, int posY,int fps,boolean finishDependant)
    {
        if (finishDependant==true)
        {
            if(finished==false)
            {
                if(counter==0){image(imageMatrix[counter],posX,posY);}
                else{image(imageMatrix[counter-1],posX,posY);}
                if((float)frameCount%(float)fps==0)
                {
                    if(counter<frameNumberAll)
                    {
                        counter++;
                    }
                    else
                    {
                        counter=0;
                        finished=true;
                    }
                }
            }
        }
        else
        {
            //println(counter);
            if(counter==0){image(imageMatrix[counter],posX,posY);}
            else{image(imageMatrix[counter-1],posX,posY);}
            if((float)frameCount%(float)fps==0)
            {
                if(counter<frameNumberAll)
                {
                counter++;
                //return true;
                }
                else 
                {
                counter=0;
                
                //return false;

                }
            }
        }
    }

    boolean Done()
    {
        return finished;
    }

    void Reset()
    {
        finished=false;
        
        //isReturningOut=false;
    }
}
