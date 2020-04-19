package com.sabaydiworldbag;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberTextWatcherForThousand implements TextWatcher {

    private EditText editText;
    private ValidateLister validateLister;


    public NumberTextWatcherForThousand(EditText editText, ValidateLister validateLister) {
        this.editText = editText;
        this.validateLister = validateLister;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        editText.removeTextChangedListener(this);
        try {
            //commit
            String originalString = s.toString();
            long defaultValue;
            if (originalString.contains(".")) {
                originalString = originalString.replaceAll("\\.", "");
            }
            defaultValue = Long.parseLong(originalString);

            DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
            formatter.applyPattern("#,###,###,###");
            String formattedString = formatter.format(defaultValue);
            //setting text after format to EditText
            editText.setText(formattedString.replaceAll(",", "."));
            editText.setSelection(editText.getText().length());
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }

        if (validateLister != null) {
            validateLister.onValidate(editText);
        }

        editText.addTextChangedListener(this);
    }

    public interface ValidateLister {
        void onValidate(EditText editText);
    }
}
