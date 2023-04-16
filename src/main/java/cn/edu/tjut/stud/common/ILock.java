package cn.edu.tjut.stud.common;

public interface ILock
{

    boolean tryLock(long timoutSec);
    void  unlock();
}
