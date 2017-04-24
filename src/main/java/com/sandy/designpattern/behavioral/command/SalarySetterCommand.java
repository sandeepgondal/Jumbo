package com.sandy.designpattern.behavioral.command;

/**
 * Created by gondals on 24/08/16.
 */
public class SalarySetterCommand implements Command {

    @Override
    public void execute(final Target target) {
        target.setSalary(122000);
    }

}
