package in.co.rays.ctl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.co.rays.bean.BaseBean;
import in.co.rays.bean.UserBean;
import in.co.rays.util.DataUtility;
import in.co.rays.util.DataValidator;
import in.co.rays.util.ServletUtility;

public abstract class BaseCtl extends HttpServlet {

    // Constants for different operations
    public static final String OP_SAVE = "Save";
    public static final String OP_UPDATE = "Update";
    public static final String OP_CANCEL = "Cancel";
    public static final String OP_DELETE = "Delete";
    public static final String OP_LIST = "List";
    public static final String OP_SEARCH = "Search";
    public static final String OP_VIEW = "View";
    public static final String OP_NEXT = "Next";
    public static final String OP_PREVIOUS = "Previous";
    public static final String OP_NEW = "New";
    public static final String OP_GO = "Go";
    public static final String OP_BACK = "Back";
    public static final String OP_RESET = "Reset";
    public static final String OP_LOG_OUT = "Logout";

    // Message Constants
    public static final String MSG_SUCCESS = "success";
    public static final String MSG_ERROR = "error";

    /**
     * Validates the request parameters. Override this in subclass controllers if specific validation is required.
     */
    protected boolean validate(HttpServletRequest request) {
        return true;
    }

    /**
     * Preloads data before the page load. Override in subclass controllers if preload functionality is needed.
     */
    protected void preload(HttpServletRequest request) {
        System.out.println("BaseCtl preload called");
    }

    /**
     * Populates a bean from the request parameters. Override in subclass controllers for specific bean population.
     */
    protected BaseBean populateBean(HttpServletRequest request) {
        return null;
    }

    /**
     * Populates basic DTO fields like createdBy, modifiedBy, createdDatetime, and modifiedDatetime.
     *
     * @param dto the BaseBean to be populated
     * @param request the HttpServletRequest containing the parameters
     * @return the populated BaseBean
     */
    protected BaseBean populateDTO(BaseBean dto, HttpServletRequest request) {
        String createdBy = request.getParameter("createdBy");
        String modifiedBy = null;

        // Retrieve the user from the session
        UserBean userBean = (UserBean) request.getSession().getAttribute("user");

        if (userBean == null) {
            createdBy = modifiedBy = "root"; // Default user if not logged in
        } else {
            modifiedBy = userBean.getLogin();

            if (DataValidator.isNull(createdBy) || "null".equalsIgnoreCase(createdBy)) {
                createdBy = modifiedBy; // Set createdBy to current user on initial creation
            }
        }

        dto.setCreatedBy(createdBy);
        dto.setModifiedBy(modifiedBy);

        long createdDatetime = DataUtility.getLong(request.getParameter("createdDatetime"));
        if (createdDatetime > 0) {
            dto.setCreatedDatetime(DataUtility.getTimestamp(createdDatetime));
        } else {
            dto.setCreatedDatetime(DataUtility.getCurrentTimestamp());
        }

        dto.setModifiedDatetime(DataUtility.getCurrentTimestamp());
        return dto;
    }

    /**
     * The main service method for handling all requests. This method handles preload, validation, and populates data.
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        preload(request);

        String op = DataUtility.getString(request.getParameter("operation"));

        // Perform validation for all operations except for these
        if (DataValidator.isNotNull(op) && !OP_CANCEL.equalsIgnoreCase(op) && !OP_VIEW.equalsIgnoreCase(op)
                && !OP_DELETE.equalsIgnoreCase(op) && !OP_RESET.equalsIgnoreCase(op)) {

            if (!validate(request)) {
                BaseBean bean = populateBean(request);
                ServletUtility.setBean(bean, request);
                ServletUtility.forward(getView(), request, response);
                return;
            }
        }

        // Pass the request to the appropriate HTTP method (GET/POST)
        super.service(request, response);
    }

    /**
     * Returns the view page for the specific controller. Each subclass must implement this method to return its view.
     */
    protected abstract String getView();
}