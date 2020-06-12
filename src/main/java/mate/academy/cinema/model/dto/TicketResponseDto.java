package mate.academy.cinema.model.dto;

import java.time.LocalDateTime;

public class TicketResponseDto {
    private String title;
    private LocalDateTime showTime;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }
}
