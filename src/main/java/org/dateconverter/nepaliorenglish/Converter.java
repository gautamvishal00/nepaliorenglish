package org.dateconverter.nepaliorenglish;

import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

import java.util.logging.Logger;

/**
 * Created by blackhat on 6/17/17.
 */
public class Converter {



        static Logger logger= Logger.getLogger(Converter.class.getName());

        public String convertToNepali(String date) {
            try {

                logger.info("The value you entered is "+date);
                //  Date date1=SimpleDateFormat()
                PythonInterpreter interpreter = new PythonInterpreter();
                interpreter.execfile("src/main/java/org/dateconverter/nepaliorenglish/dateconverter.py");
                PyObject str = interpreter.eval("convertNepali('"+date+"')");

                logger.info("The value returned is "+str.toString());
                return str.toString().replaceAll("-","/");
            }catch(Exception e){
                logger.severe(e.toString());
                return null;
            }


        }
        public String convertToEnglish(String date) {
            try {

                logger.info("The value you entered is "+date);

                PythonInterpreter interpreter = new PythonInterpreter();
                interpreter.execfile("src/main/java/org/dateconverter/nepaliorenglish/dateconverter.py");
                PyObject str = interpreter.eval("convertEnglish('"+date+"')");

                logger.info("The value returned is "+str.toString());
                return str.toString().replaceAll("-","/");
            }catch(Exception e){
                logger.severe(e.toString());
                return null;

            }

        }

    }

