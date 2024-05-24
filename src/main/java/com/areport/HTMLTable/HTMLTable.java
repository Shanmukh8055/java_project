package com.areport.HTMLTable;

import java.util.ArrayList;
import java.util.List;

public class HTMLTable extends HTMLCommon {

    private static final String _attributes = null;
    private String _autoFill = "&nbsp;";
    private boolean _autoGrow = true;
    private HTMLTableStorage _thead = null;
    private HTMLTableStorage _tfoot = null;
    private List<HTMLTableStorage> _tbodies = new ArrayList<>();
    private int _tbodyCount = 0;
    private boolean _useTGroups = false;
    private Object _comment;

    public HTMLTable(Object attributes, int tabOffset, boolean useTGroups) {
        super(attributes, tabOffset);
        _useTGroups = useTGroups;
        addBody(attributes);
        if (_useTGroups) {
            _thead = new HTMLTableStorage(tabOffset, _useTGroups);
            _tfoot = new HTMLTableStorage(tabOffset, _useTGroups);
        }
    }

    public HTMLTable(Object attributes, int tabOffset) {
        this(attributes, tabOffset, false);
    }

    public double apiVersion() {
        return 1.7;
    }

    public Object getHeader() {
        if (_thead == null) {
            _useTGroups = true;
            _thead = new HTMLTableStorage(_tbodyCount, _useTGroups);
            for (int i = 0; i < _tbodyCount; i++) {
                _tbodies.get(i).setUseTGroups(true);
            }
        }
        return _thead;
    }

    public Object getFooter() {
        if (_tfoot == null) {
            _useTGroups = true;
            _tfoot = new HTMLTableStorage(_tbodyCount, _useTGroups);
            for (int i = 0; i < _tbodyCount; i++) {
                _tbodies.get(i).setUseTGroups(true);
            }
        }
        return _tfoot;
    }

    public Object getBody(int body) {
        int ret = _adjustTbodyCount(body, "getBody");
        if (ret != -1) {
            return _tbodies.get(body);
        }
        return null;
    }

    public int addBody(Object attributes) {
        if (!_useTGroups && _tbodyCount > 0) {
            for (int i = 0; i < _tbodyCount; i++) {
                _tbodies.get(i).setUseTGroups(true);
            }
            _useTGroups = true;
        }
        int body = _tbodyCount++;
        _tbodies.add(new HTMLTableStorage(_tbodyCount, _useTGroups));
        _tbodies.get(body).setAutoFill(_autoFill);
        _tbodies.get(body).setAttributes(attributes);
        return body;
    }

    private int _adjustTbodyCount(int body, String method) {
        if (_autoGrow) {
            while (_tbodyCount <= body) {
                addBody(method);
            }
            return body;
        } else {
            // return Error::raiseError('Invalid body reference[' +
            // body + '] in HTML_Table::' + method);
            return -1;
        }
    }

    // Other methods go here...

    public String toHtml() {
        String strHtml = "";
        String tabs = _getTabs();
        String lnEnd = _getLineEnd();
        List<Integer> tBodyColCounts = new ArrayList<>();
        for (int i = 0; i < _tbodyCount; i++) {
            tBodyColCounts.add(_tbodies.get(i).getColCount());
        }
        int tBodyMaxColCount = 0;
        if (tBodyColCounts.size() > 0) {
            tBodyMaxColCount = tBodyColCounts.stream().mapToInt(Integer::intValue).max().orElse(0);
        }
        if (_comment != null && !((String) _comment).isEmpty()) {
            strHtml += tabs + "<!-- " + _comment + " -->" + lnEnd;
        }
        if (getRowCount() > 0 && tBodyMaxColCount > 0) {
            strHtml += tabs + "<table" + _getAttrString(_attributes) + ">" + lnEnd;
            // Other parts of the HTML generation...
            strHtml += tabs + "</table>" + lnEnd;
        }
        return strHtml;
    }

    private String _getAttrString(String attributes) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method '_getAttrString'");
    }

    private int getRowCount() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRowCount'");
    }

    private String _getLineEnd() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method '_getLineEnd'");
    }

    private String _getTabs() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method '_getTabs'");
    }

    @Override
    public String toString() {
        return toHtml();
    }
}