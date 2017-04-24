package com.sandy.designpattern.behavioral.command;

/**
 * Created by gondals on 24/08/16.
 */

@FunctionalInterface
public interface Command {

    void execute(Target target);

}
